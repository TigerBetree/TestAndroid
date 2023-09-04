import 'dart:async';

import 'package:flutter/material.dart';

class ListviewBuilderRefreshIndicatorDemo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return ListviewBuilderRefreshIndicatorState();
  }
}

class ListviewBuilderRefreshIndicatorState
    extends State<ListviewBuilderRefreshIndicatorDemo> {
  @override
  Widget build(BuildContext context) {
    var _routes = <String, WidgetBuilder>{
      "/todos": (BuildContext context) => new TodosPage(),
    };

    return new MaterialApp(
      title: 'My App',
      theme: new ThemeData(primaryColor: Colors.blue),
      home: new MyHomePage(),
      routes: _routes,
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new MyHomePageState();
  }
}

class MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('My Home Page'),
      ),
      body: new RaisedButton(
          child: new Text('Show My Todos'),
          onPressed: () => Navigator.of(context).pushNamed("/todos")),
    );
  }
}

class TodosPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new TodosPageState();
  }
}

class TodosPageState extends State<TodosPage> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("My Todos"),
      ),
      body: new RefreshIndicator(
          child: new ListView.builder(itemBuilder: _itemBuilder),
          onRefresh: _onRefresh),
    );
  }

  Future<Null> _onRefresh() {
    Completer<Null> completer = new Completer<Null>();
    Timer timer = new Timer(new Duration(seconds: 1), () {
      completer.complete();
    });
    return completer.future;
  }

  Widget _itemBuilder(BuildContext context, int index) {
    Todo todo = getTodo(index);
    return new TodoItemWidget(
      todo: todo,
    );
  }

  Todo getTodo(int index) {
    return new Todo(false, "Todo $index");
  }
}

class TodoItemWidget extends StatefulWidget {
  TodoItemWidget({Key key, this.todo}) : super(key: key);

  final Todo todo;

  @override
  State<StatefulWidget> createState() {
    return new TodoItemWidgetState();
  }
}

class TodoItemWidgetState extends State<TodoItemWidget> {
  @override
  Widget build(BuildContext context) {
    return new ListTile(
      leading: new Text('-'),
      title: new Text(widget.todo.name),
      onTap: _onTap,
    );
  }

  void _onTap() {
    Route route = new MaterialPageRoute(
        settings: new RouteSettings(name: "/todos/todo"),
        builder: (BuildContext context) => new TodoPage(
              todo: widget.todo,
            ));
    Navigator.of(context).push(route);
  }
}

class TodoPage extends StatefulWidget {
  TodoPage({Key key, this.todo}) : super(key: key);

  final Todo todo;

  @override
  State<StatefulWidget> createState() {
    return new TodoPageState();
  }
}

class TodoPageState extends State<TodoPage> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("My Todo"),
      ),
      body: new Column(
        children: [
          new Text("finished : " + widget.todo.finished.toString()),
          new Text("name : " + widget.todo.name.toString()),
        ],
      ),
    );
  }
}

class Todo {
  bool finished;
  String name;

  Todo(this.finished, this.name);
}
