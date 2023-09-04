import 'package:flutter/material.dart';

class MySandyShoresApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var routes = <String, WidgetBuilder>{
      SandyShores.routeName: (BuildContext context) => new SandyShores(),
    };

    return new MaterialApp(
      title: "Flutter Demo",
      home: new MySandyShoresHomePage(title: "HomePage"),
      routes: routes,
    );
  }
}

class MySandyShoresHomePage extends StatefulWidget {
  final String title;

  MySandyShoresHomePage({Key key, this.title}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _MySandyShoresHomePageState();
  }
}

class _MySandyShoresHomePageState extends State<MySandyShoresHomePage> {
  @override
  Widget build(BuildContext context) {
    var headerText = new Text("Headers");

    var header = new DrawerHeader(child: headerText);

    var item1Text = new Text('Sandy Shores');

    var item1Icon = new Icon(Icons.settings);

    var item1 = new ListTile(
      title: item1Text,
      leading: item1Icon,
      onTap: _onItem1OnTap,
    );

    var children = [header, item1];

    var listView = new ListView(
      children: children,
    );

    var drawer = new Drawer(
      child: listView,
    );

    return new Scaffold(
      drawer: drawer,
      appBar: new AppBar(
        title: new Text("Tabs Demo"),
      ),
      body: new Center(
        child: new Text(''),
      ),
    );
  }

  void _onItem1OnTap() {
    Navigator.popAndPushNamed(context, SandyShores.routeName);
  }
}

class SandyShores extends StatelessWidget {
  static String routeName = "SandyShores";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'SandyShores',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new Center(
        child: new Text("You've landed on the Sandy Shores."),
      ),
    );
  }
}
