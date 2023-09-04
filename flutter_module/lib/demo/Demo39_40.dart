import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class ListViewBuilderDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return ListViewBuilderState();
  }
}

class ListViewBuilderState extends State<ListViewBuilderDemo> {
  Map _countries = new Map();

  /// 使用http.dart库 获取网络数据
  /// 使用 json 库进行数据解析
  void _getData() async {
    var url = "http://country.io/names.json";
    var response = await http.get(url);

    if (response.statusCode == 200) {
      setState(() {
        _countries = json.decode(response.body);
      });
    }
  }

  @override
  void initState() {
    super.initState();
    _getData();
  }

  List _pets = ['Dogs', 'Cats', 'Fish'];

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
              new Text(
                'Countries',
                style:
                    new TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
              ),
              new Expanded(
                  flex: 1,
                  child: new ListView.builder(
                      itemCount: _pets.length,
                      itemBuilder: (BuildContext context, int index) {
                        return new Text(_pets.elementAt(index));
                      })),
              new Expanded(
                flex: 3,
                child: new ListView.builder(
                    itemCount: _countries.length,
                    itemBuilder: (BuildContext context, int index) {
                      String key = _countries.keys.elementAt(index);
                      return new Row(
                        children: [
                          new Text('${key} : '),
                          new Text(_countries[key]),
                        ],
                      );
                    }),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
