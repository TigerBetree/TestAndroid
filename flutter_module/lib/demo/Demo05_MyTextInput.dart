import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyTextInput extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new MyTextInputState();
  }
}

class MyTextInputState extends State<MyTextInput> {

  final TextEditingController controller = new TextEditingController();

  String result = "";

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Input Text"),
        backgroundColor: Colors.deepOrange,
      ),
      body: new Container(
        child: new Center(
          child: new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              new TextField(
                decoration: new InputDecoration(hintText: "Type in here"),
                // onChanged is called whenever we add or delete something on Text Field
                // onChanged: (String str) {
                //   setState(() {
                //     result = str;
                //   });
                // },
                // 输入完成并确定后（TextField失去焦点）
                onSubmitted: (String str) {
                  setState(() {
                    result = result + "\n" + str;
                  });
                  controller.text = "";
                },
                controller: controller,
              ),
              new Text(result)
            ],
          ),
        ),
      ),
    );
  }
}
