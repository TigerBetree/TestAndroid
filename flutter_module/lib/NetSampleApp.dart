import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class NetSampleApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Net Sample App',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new NetSampleAppPage(),
    );
  }
}

class NetSampleAppPage extends StatefulWidget {
  NetSampleAppPage({Key key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return new _NetSampleAppPage();
  }
}

class _NetSampleAppPage extends State<NetSampleAppPage> {
  List widgets = [];

  @override
  void initState() {
    super.initState();

    loadData();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: new AppBar(
          title: new Text("Net Sample App"),
        ),
        body: getBody());
  }

  showLoadingDialog() {
    if (widgets.length == 0) {
      return true;
    }

    return false;
  }

  getBody() {
    if (showLoadingDialog()) {
      return getProgressDialog();
    } else {
      return getListView();
    }
  }

  ListView getListView() => new ListView.builder(
      itemCount: widgets.length,
      itemBuilder: (BuildContext context, int position) {
        return getRow(position);
      });

  Widget getRow(int i) {
    return new Padding(
        padding: new EdgeInsets.all(10.0),
        child: new Text("Row ${widgets[i]["title"]}"));
  }

  // 进度条
  getProgressDialog() {
    return new Center(child: new CircularProgressIndicator());
  }

  loadData() async {
    String url = "https://jsonplaceholder.typicode.com/posts";
    http.Response response = await http.get(url);
    setState(() {
      widgets = json.decode(response.body);
    });
  }
}
