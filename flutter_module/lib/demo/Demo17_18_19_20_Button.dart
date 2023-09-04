import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

///
/// RaiseButton
/// FlatButton
/// IconButton
///
///
class ButtonDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return ButtonDemoState();
  }
}

class ButtonDemoState extends State<ButtonDemo> {
  String _value = 'Hello World';
  int _counter = 0;

  void _onPressed() {
    setState(() {
      _value = "My Name is Tiger";
    });
  }

  void _onPressedWithParam(String value) {
    setState(() {
      _value = value;
    });
  }

  void _onPressed_FlatButton() {
    setState(() {
      _value = new DateTime.now().toString();
    });
  }

  void _add() {
    setState(() {
      _counter++;
    });
  }

  void _subtract() {
    setState(() {
      _counter--;
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Name here?"),
      ),
      body: new Container(
        padding: new EdgeInsets.all(32.0),
        child: new Center(
          child: new Column(
            children: <Widget>[
              new Text(_value),
              new RaisedButton(
                onPressed: _onPressed,
                child: new Text('click me'),
              ),
              new RaisedButton(
                onPressed: () => _onPressedWithParam("Hello Hu"),
                child: new Text('click me too'),
              ),
              new FlatButton(
                  onPressed: _onPressed_FlatButton,
                  child: new Text('FlatButton')),
              new Text("Counter = ${_counter}"),
              new IconButton(icon: new Icon(Icons.add), onPressed: _add),
              new IconButton(
                  icon: new Icon(Icons.remove), onPressed: _subtract),
            ],
          ),
        ),
      ),
    );
  }
}