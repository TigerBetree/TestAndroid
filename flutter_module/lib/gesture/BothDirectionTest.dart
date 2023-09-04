import 'package:flutter/material.dart';

class BothDirectionTest extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'BothDirectionTest',
      theme: new ThemeData(
        primarySwatch: Colors.blue, // 主色板
      ),
      home: Scaffold(
        appBar: new AppBar(
          title: new Text('BothDirectionTest'),
        ),
        body: new BothDirectionTestRoute(),
      ),
    );
  }
}

class BothDirectionTestRoute extends StatefulWidget {
  @override
  BothDirectionTestRouteState createState() =>
      new BothDirectionTestRouteState();
}

class BothDirectionTestRouteState extends State<BothDirectionTestRoute> {
  double _top = 0.0;
  double _left = 0.0;

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        Positioned(
          top: _top,
          left: _left,
          child: GestureDetector(
            child: CircleAvatar(child: Text("A")),
            //垂直方向拖动事件
            onVerticalDragUpdate: (DragUpdateDetails details) {
              setState(() {
                _top += details.delta.dy;
              });
            },
            onHorizontalDragUpdate: (DragUpdateDetails details) {
              setState(() {
                _left += details.delta.dx;
              });
            },
          ),
        ),
        // Padding(
        //   padding: EdgeInsets.only(
        //     top: 300.0,
        //   ),
        //   child: Positioned(
        //     left: _left,
        //     child: GestureDetector(
        //       child: CircleAvatar(child: Text("B")),
        //       //要拖动和点击的widget
        //       onHorizontalDragUpdate: (DragUpdateDetails details) {
        //         setState(() {
        //           _left += details.delta.dx;
        //         });
        //       },
        //       onHorizontalDragEnd: (details) {
        //         print("onHorizontalDragEnd");
        //       },
        //       onTapDown: (details) {
        //         print("down");
        //       },
        //       onTapUp: (details) {
        //         print("up");
        //       },
        //     ),
        //   ),
        // ),
      ],
    );
  }
}
