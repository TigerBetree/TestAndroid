import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class HttpTestPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new HttpTestPageState();
  }
}

class HttpTestPageState extends State<HttpTestPage> {
  Future<String> getData() async {
    http.Response response = await http.get(
        Uri.encodeFull("https://jsonplaceholder.typicode.com/posts"),
        headers: {"Accept": "application/json"});

    setState(() {
      data = json.decode(response.body);
    });
  }

  List data;

  @override
  void initState() {
    this.getData();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Http Req Demo"),
        backgroundColor: Colors.blue,
      ),
      body: new ListView.builder(
          itemCount: data == null ? 0 : data.length,
          itemBuilder: (BuildContext context, int index) {
            return new Card(
              child: new Text(data[index]['title']),
            );
          }),
    );
  }
}
