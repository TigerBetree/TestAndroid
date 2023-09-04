import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:toast/toast.dart';

class RowColumnDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return RowColumnState();
  }
}

class RowColumnState extends State<RowColumnDemo> {
  TextEditingController _user = new TextEditingController();
  TextEditingController _pass = new TextEditingController();

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
              new Text('Please login'),
              new Row(
                children: [
                  new Text('UserName: '),
                  new Expanded(
                      child: new TextField(
                    controller: _user,
                  ))
                ],
              ),
              new Row(
                children: [
                  new Text('Password: '),
                  new Expanded(
                      child: new TextField(
                    controller: _pass,
                  ))
                ],
              ),
              new Padding(
                  padding: new EdgeInsets.all(32.0),
                  child: new RaisedButton(
                    onPressed: () => Toast.show("Login ${_user.text}", context),
                    child: new Text('Click me'),
                  )),
              new Card(
                child: new Container(
                  padding: new EdgeInsets.all(32.0),
                  child: new Column(
                    children: [
                      new Text('Hello World. 1'),
                      new Text('How are you. 1'),
                    ],
                  ),
                ),
              ),
              new Card(
                child: new Container(
                  padding: new EdgeInsets.all(32.0),
                  child: new Column(
                    children: [
                      new Text('Hello World. 2'),
                      new Text('How are you. 2'),
                    ],
                  ),
                ),
              ),
              new Expanded(
                  child: new Image.network(
                      'https://static.makeuseof.com/wp-content/uploads/2012/10/flutter-logo.jpg')),
            ],
          ),
        ),
      ),
    );
  }
}
