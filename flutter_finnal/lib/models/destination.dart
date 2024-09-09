class Destination {
  final String name;
  final String imageUrl;

  Destination({required this.name, required this.imageUrl});

  factory Destination.fromJson(Map<String, dynamic> json) {
    return Destination(
      name: json['name'],
      imageUrl: json['imageUrl'],
    );
  }
}
