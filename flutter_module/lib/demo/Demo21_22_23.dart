import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

///
/// RaiseButton
/// FlatButton
/// IconButton
///
///
class TextFieldDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return TextFieldDemoState();
  }
}

class TextFieldDemoState extends State<TextFieldDemo> {
  String _value = '';

  void _onChanged(String value) {
    setState(() {
      _value = "Change: ${value}";
    });
  }

  void _onSubmit(String value) {
    setState(() {
      _value = "Submit: ${value}";
    });
  }

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

  int value1 = 0;
  int value2 = 0;

  void _setValue1(int value) {
    setState(() {
      value1 = value;
    });
  }

  void _setValue2(int value) {
    setState(() {
      value2 = value;
    });
  }

  Widget makeRadios() {
    List<Widget> list = new List<Widget>();

    for (int i = 0; i < 3; i++) {
      list.add(new Radio(
        value: i,
        groupValue: value1,
        onChanged: _setValue1,
      ));
    }

    Column column = new Column(
      children: list,
    );

    return column;
  }

  Widget makeRadioTiles() {
    List<Widget> list = new List<Widget>();

    for (int i = 0; i < 3; i++) {
      list.add(new RadioListTile(
        value: i,
        groupValue: value2,
        onChanged: _setValue2,
        activeColor: Colors.green,
        controlAffinity: ListTileControlAffinity.trailing,
        title: new Text("Item: ${i}"),
        subtitle: new Text("Sub title"),
      ));
    }

    Column column = new Column(
      children: list,
    );
    return column;
  }

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
              new Text(_value),
              new TextField(
                decoration: new InputDecoration(
                    labelText: "Hello",
                    hintText: "hint",
                    icon: new Icon(Icons.people)),
                autocorrect: true,
                autofocus: true,
                keyboardType: TextInputType.text,
                onChanged: _onChanged,
                onSubmitted: _onSubmit,
              ),
              new Checkbox(value: _value1, onChanged: _value1Changed),
              new CheckboxListTile(
                value: _value2,
                onChanged: _value2Changed,
                title: new Text('Hello World'),
                controlAffinity: ListTileControlAffinity.leading,
                subtitle: new Text("Subtitle"),
                secondary: new Icon(Icons.archive),
                activeColor: Colors.red,
              ),
              makeRadios(),
              makeRadioTiles(),
            ],
          ),
        ),
      ),
    );
  }
}
