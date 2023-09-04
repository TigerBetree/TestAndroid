import 'package:flutter/material.dart';

class ListViewSample extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'ListViewSample',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new ListViewSamplePage(),
    );
  }
}

class ListViewSamplePage extends StatefulWidget {
  ListViewSamplePage({Key key}) : super(key: key);

  @override
  _ListViewSamplePageState createState() => new _ListViewSamplePageState();
}

class _ListViewSamplePageState extends State<ListViewSamplePage> {
  List widgets = [];

  @override
  void initState() {
    super.initState();
    for (int i = 0; i < 100; i++) {
      widgets.add(getRow(i));
    }
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: new AppBar(
          title: new Text("ListViewSample"),
        ),
        body: new ListView.builder(
            itemCount: widgets.length,
            itemBuilder: (BuildContext context, int position) {
              return getRow(position);
            }));
  }

  Widget getRow(int i) {
    return new GestureDetector(
      child: new Padding(
          padding: new EdgeInsets.all(10.0), child: new Text("Row $i")),
      onTap: () {
        setState(() {
          widgets.add(getRow(widgets.length + 1));
          print('row $i');
        });
      },
    );
  }
}
