import 'package:flutter/material.dart';

class DragVerticalTest extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'DragVerticalTest',
      theme: new ThemeData(
        primarySwatch: Colors.blue, // 主色板
      ),
      home: Scaffold(
        appBar: new AppBar(
          title: new Text('DragVerticalTest'),
        ),
        body: new _DragVertical(),
      ),
    );
  }
}

class _DragVertical extends StatefulWidget {
  @override
  _DragVerticalState createState() => new _DragVerticalState();
}

class _DragVerticalState extends State<_DragVertical> {
  double _top = 0.0;

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        Positioned(
          top: _top,
          child: GestureDetector(
              child: CircleAvatar(child: Text("A")),
              //垂直方向拖动事件
              onVerticalDragUpdate: (DragUpdateDetails details) {
                setState(() {
                  _top += details.delta.dy;
                });
              }),
        )
      ],
    );
  }
}
