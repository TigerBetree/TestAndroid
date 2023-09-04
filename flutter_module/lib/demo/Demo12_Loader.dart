import 'package:flutter/material.dart';

class LoaderHome extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      backgroundColor: Colors.blueAccent,
      body: new Center(
        child: new Loader(),
      ),
    );
  }
}

class Loader extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new _LoaderState();
  }
}

class _LoaderState extends State<Loader> with SingleTickerProviderStateMixin {
  AnimationController controller;
  Animation<double> animation;

  @override
  void initState() {
    super.initState();
    controller = new AnimationController(
        duration: new Duration(microseconds: 800), vsync: this);
    animation =
        new CurvedAnimation(parent: controller, curve: Curves.bounceOut);
    animation.addListener(() {
      this.setState(() {});
    });
    animation.addStatusListener((status) {});

    controller.repeat();
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        new Container(
          color: Colors.white,
          height: 3.0,
          width: animation.value * 100.0, //animation.value ranges from 0 to 1
        ),
        new Padding(padding: new EdgeInsets.only(bottom: 5.0)),
        new Container(
          color: Colors.white,
          height: 3.0,
          width: animation.value * 75.0, //animation.value ranges from 0 to 1
        ),
        new Padding(padding: new EdgeInsets.only(bottom: 5.0)),
        new Container(
          color: Colors.white,
          height: 3.0,
          width: animation.value * 50.0, //animation.value ranges from 0 to 1
        ),
      ],
    );
  }
}
