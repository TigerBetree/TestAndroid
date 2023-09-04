import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

///
/// Switch
/// Slider
/// DatePicker
/// appBar
///
///
class SwitchDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return SwitchDemoState();
  }
}

class SwitchDemoState extends State<SwitchDemo> {
  bool _value1 = false;
  bool _value2 = false;

  void _value1Changed(bool value) {
    setState(() {
      _value1 = value;
    });
  }

  void _value2Changed(bool value) {
    setState(() {
      _value2 = value;
    });
  }

  double _value = 0.0;

  void _setValue(double v) {
    setState(() {
      _value = v;
    });
  }

  String _dateValue = "";

  Future _selectDate() async {
    DateTime picked = await showDatePicker(
        context: context,
        initialDate: new DateTime.now(),
        firstDate: new DateTime(2016),
        lastDate: new DateTime(2021));

    if (picked != null) {
      setState(() {
        _dateValue = picked.toString();
      });
    }
  }

  int counter = 0;

  void _add() {
    setState(() {
      counter++;
    });
  }

  void _remove() {
    setState(() {
      counter--;
    });
  }

  String _floatingValue = "";

  void _onFloatingButtonClicked() {
    setState(() {
      _floatingValue = new DateTime.now().toString();
    });
  }

  String _footerValue = '';

  void _onFooterButtonClicked(String value) {
    setState(() {
      _floatingValue = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Name here"),
        actions: [
          new IconButton(icon: new Icon(Icons.add), onPressed: _add),
          new IconButton(icon: new Icon(Icons.remove), onPressed: _remove),
        ],
      ),
      floatingActionButton: new FloatingActionButton(
        onPressed: _onFloatingButtonClicked,
        backgroundColor: Colors.red,
        mini: false,
        child: new Icon(Icons.timer),
      ),
      drawer: new Drawer(
        child: new Container(
          padding: new EdgeInsets.all(32.0),
          child: new Column(
            children: [
              new Text('Hello Drawer'),
              new RaisedButton(
                onPressed: () => Navigator.pop(context),
                child: new Text('Close'),
              )
            ],
          ),
        ),
      ),
      persistentFooterButtons: [
        new IconButton(
            icon: new Icon(Icons.timer),
            onPressed: () => _onFooterButtonClicked('Button1')),
        new IconButton(
            icon: new Icon(Icons.people),
            onPressed: () => _onFooterButtonClicked('Button2')),
        new IconButton(
            icon: new Icon(Icons.map),
            onPressed: () => _onFooterButtonClicked('Button3')),
      ],
      body: new Container(
        padding: new EdgeInsets.all(32.0),
        child: new Center(
          child: new Column(
            children: <Widget>[
              new Text(
                counter.toString(),
                style:
                    new TextStyle(fontWeight: FontWeight.bold, fontSize: 37.0),
              ),
              new Switch(
                value: _value1,
                onChanged: _value1Changed,
              ),
              new SwitchListTile(
                value: _value2,
                onChanged: _value2Changed,
                title: new Text(
                  'Hello World',
                  style: new TextStyle(
                      fontWeight: FontWeight.bold, color: Colors.red),
                ),
              ),
              new Text('Value: ${(_value * 100).round()}'),
              new Slider(value: _value, onChanged: _setValue),
              new Text(_dateValue),
              new RaisedButton(
                onPressed: _selectDate,
                child: new Text('Click me'),
              ),
              new Text(_floatingValue),
              new Text(_footerValue),
            ],
          ),
        ),
      ),
    );
  }
}
