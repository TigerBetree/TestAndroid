import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BottomNavigationBarDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return BottomNavigationBarState();
  }
}

/// 枚举类型。。
enum Answers { YES, NO, MAYBE }

class BottomNavigationBarState extends State<BottomNavigationBarDemo> {
  List<BottomNavigationBarItem> _items;
  String _value = '';
  int _index = 0;

  @override
  void initState() {
    super.initState();

    _items = new List();
    _items.add(new BottomNavigationBarItem(
        icon: new Icon(Icons.people), title: new Text('People')));
    _items.add(new BottomNavigationBarItem(
        icon: new Icon(Icons.weekend), title: new Text('Weekend')));
    _items.add(new BottomNavigationBarItem(
        icon: new Icon(Icons.message), title: new Text('Message')));
  }

  void _showBottomSheet() {
    showModalBottomSheet(
        context: context,
        builder: (BuildContext context) {
          return new Container(
            padding: new EdgeInsets.all(15.0),
            child: new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                new Text(
                  "Some info here",
                  style: new TextStyle(
                      color: Colors.red,
                      fontWeight: FontWeight.bold,
                      fontSize: 20.0),
                ),
                new RaisedButton(
                  onPressed: () => Navigator.pop(context),
                  child: new Text('close'),
                )
              ],
            ),
          );
        });
  }

  final GlobalKey<ScaffoldState> _scaffoldState =
      new GlobalKey<ScaffoldState>();

  void _showSnackBar() {
    _scaffoldState.currentState
        .showSnackBar(new SnackBar(content: new Text('Hello SnackBar')));
  }

  /// 显示Alert或Dialog，要用 Future  async TODO
  Future _showAlert(BuildContext context, String message) async {
    return showDialog(
        context: context,
        child: new AlertDialog(
          title: new Text(message),
          actions: [
            new FlatButton(
                onPressed: () => Navigator.pop(context), child: new Text('Ok'))
          ],
        ));
  }

  String _dialogValue = '';

  void _setDialogValue(String v) {
    setState(() {
      _dialogValue = v;
    });
  }

  Future _askUser() async {
    switch (await showDialog(
        context: context,
        child: new SimpleDialog(
          title: new Text('Do you like Flutter?'),
          children: [
            new SimpleDialogOption(
              child: new Text('Yes'),
              onPressed: () {
                Navigator.pop(context, Answers.YES);
              },
            ),
            new SimpleDialogOption(
              child: new Text('No'),
              onPressed: () {
                Navigator.pop(context, Answers.NO);
              },
            ),
            new SimpleDialogOption(
              child: new Text('Maybe'),
              onPressed: () {
                Navigator.pop(context, Answers.MAYBE);
              },
            )
          ],
        ))) {
      case Answers.YES:
        _setDialogValue('Yes');
        break;
      case Answers.NO:
        _setDialogValue('No');
        break;
      case Answers.MAYBE:
        _setDialogValue('Maybe');
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Name here"),
      ),
      key: _scaffoldState,
      body: new Container(
        padding: new EdgeInsets.all(32.0),
        child: new Center(
          child: new Column(
            children: <Widget>[
              new Text(_value),
              new RaisedButton(
                onPressed: _showBottomSheet,
                child: new Text("Show BottomSheet"),
              ),
              new RaisedButton(
                onPressed: _showSnackBar,
                child: new Text("Show SnackBar"),
              ),
              new RaisedButton(
                onPressed: () => _showAlert(context, "Alert Dialog"),
                child: new Text("Show Alert"),
              ),
              new Text(_dialogValue),
              new RaisedButton(
                onPressed: _askUser,
                child: new Text("Show SimpleDialog"),
              )
            ],
          ),
        ),
      ),
      bottomNavigationBar: new BottomNavigationBar(
        items: _items,
        fixedColor: Colors.blue,
        currentIndex: _index,
        onTap: (int item) {
          setState(() {
            _index = item;
            _value = "Current value is ${_index.toString()}";
          });
        },
      ),
    );
  }
}
