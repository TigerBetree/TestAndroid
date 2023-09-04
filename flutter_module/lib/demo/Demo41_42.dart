import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class CustomWidgetDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CustomWidgetState();
  }
}

class CustomWidgetState extends State<CustomWidgetDemo> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Name here"),
      ),
      body: new Container(
        padding: new EdgeInsets.all(32.0),
        child: new Center(
          child: new Column(
            children: <Widget>[
              new Texty(),
              new MyExploreWidget(),
            ],
          ),
        ),
      ),
    );
  }
}

class Texty extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new Text('This works.'),
    );
  }
}

class MyExploreWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var assetsImage = new AssetImage('images/head.jpg');
    var image = new Image(
      image: assetsImage,
      width: 48.0,
      height: 48.0,
    );
    return new Container(
      child: image,
    );
  }
}
