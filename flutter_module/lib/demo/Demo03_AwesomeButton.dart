import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Demo03_AwesomeButton extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new Demo03_AwesomeButtonState();
  }
}

class Demo03_AwesomeButtonState extends State<Demo03_AwesomeButton> {
  int counter = 0;
  List<String> strings = ["Flutter", "Is", "Awesome"];
  String displayedString = "";

  void onPressed() {
    setState(() {
      displayedString = strings[counter];
      counter = counter < 2 ? counter + 1 : 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("AwesomeButton"),
        backgroundColor: Colors.deepOrange,
      ),
      body: new Container(
        child: new Center(
          child: new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Text(
                displayedString,
                style:
                    new TextStyle(fontSize: 30.0, fontWeight: FontWeight.bold),
              ),
              new Padding(padding: new EdgeInsets.all(15.0)),
              new RaisedButton(
                onPressed: onPressed,
                color: Colors.red,
                child: new Text(
                  "Press me",
                  style: new TextStyle(
                      color: Colors.white,
                      fontStyle: FontStyle.italic,
                      fontSize: 20.0),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
