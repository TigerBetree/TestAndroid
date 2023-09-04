import 'package:flutter/material.dart';

class SampleApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Sample App'),
      ),
      body: new SampleAppPage(),
    );
  }
}

class SampleAppPage extends StatefulWidget {
  SampleAppPage({Key key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return new _SampleAppPageState();
  }
}

class _SampleAppPageState extends State<SampleAppPage> {
  String textToShow = "I Like Flutter.";

  void _updateText() {
    setState(() {
      textToShow = "Flutter is Awesome.";
    });
  }

  bool toggle = true;

  void _toggle() {
    setState(() {
      toggle = !toggle;
      if (!toggle) {
        textToShow = "I Like Flutter.";
      }
    });
  }

  _getToggleChild() {
    if (toggle) {
      return new Text('Toggle One');
    } else {
      return new MaterialButton(
        onPressed: _updateText,
        child: new Text(textToShow),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Sample App"),
      ),
      body: new Center(
        child: _getToggleChild(),
      ),
      floatingActionButton: new FloatingActionButton(
          tooltip: 'Update Text',
          child: new Icon(Icons.update),
          onPressed: _toggle),
    );
  }
}
