import 'package:flutter/material.dart';
import 'package:flutter_finnal/models/destination.dart';
import 'dart:convert'; // For decoding the API response
import 'package:http/http.dart' as http; // For making HTTP requests

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Destination> destinations = [];

  @override
  void initState() {
    super.initState();
    getAllPlaces();
  }

  // API call to fetch destinations
  Future<void> getAllPlaces() async {
    final response = await http.get(Uri.parse('http://localhost:8080/api/places'));

    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body);
      setState(() {
        destinations = jsonResponse.map((data) => Destination.fromJson(data)).toList();
      });
    } else {
      throw Exception('Failed to load destinations');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'Hi, guy!',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 8),
              Text(
                'Where are you going next?',
                style: TextStyle(fontSize: 18, color: Colors.grey[600]),
              ),
              SizedBox(height: 16),

              // Search Button
              TextField(
                decoration: InputDecoration(
                  hintText: 'Search your destination',
                  prefixIcon: Icon(Icons.search),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(30),
                  ),
                ),
              ),
              SizedBox(height: 16),

              // 3 Columns
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  _buildCategoryCard('Hotels', Colors.redAccent, Icons.hotel), // Hotel Icon
                  _buildCategoryCard('Flights', Colors.greenAccent, Icons.flight), // Flight Icon
                  _buildCategoryCard('All', Colors.blueAccent, Icons.grid_view), // General "All" Icon
                ],
              ),

              SizedBox(height: 24),

              // Popular Destination Title
              Text(
                'Popular Destination',
                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 16),

              // 2-Column Layout for Cards
              destinations.isNotEmpty
                  ? GridView.builder(
                shrinkWrap: true,
                physics: NeverScrollableScrollPhysics(),
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2,
                  crossAxisSpacing: 16,
                  mainAxisSpacing: 16,
                  childAspectRatio: 3 / 2,
                ),
                itemCount: destinations.length,
                itemBuilder: (context, index) {
                  return _buildDestinationCard(destinations[index]);
                },
              )
                  : Center(child: CircularProgressIndicator()), // Show loading spinner while fetching data
            ],
          ),
        ),
      ),
    );
  }

  // Helper method to create category cards with an icon
  Widget _buildCategoryCard(String title, Color color, IconData icon) {
    return Expanded(
      child: Card(
        color: color,
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            children: [
              Icon(icon, size: 40, color: Colors.white), // Use the passed icon
              SizedBox(height: 8),
              Text(
                title,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // Helper method to create destination cards
  Widget _buildDestinationCard(Destination destination) {
    return Card(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            child: Image.network(
              destination.imageUrl, // Use the dynamic image URL from the API
              fit: BoxFit.cover,
              width: double.infinity,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              destination.name,  // Use the dynamic name from the API
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
          ),
        ],
      ),
    );
  }
}
