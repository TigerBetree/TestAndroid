import 'package:flutter/material.dart';

/// Switch 控件
/// CheckBox 控件
/// LinearProgressIndicator
/// CircularProgressIndicator
/// TextField
/// RaisedButton
/// SizedBox：尺寸限制类Widget
/// SingleChildScrollView
class WidgetTest extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ImageAndIcon',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new Scaffold(
          appBar: new AppBar(
            title: new Text("ImageAndIcon"),
          ),
          body: WidgetTestTestRoute()),
    );
  }
}

class WidgetTestTestRoute extends StatefulWidget {
  @override
  _WidgetTestTestRouteState createState() => new _WidgetTestTestRouteState();
}

class _WidgetTestTestRouteState extends State<WidgetTestTestRoute>
    with SingleTickerProviderStateMixin {
  bool _switchSelected = true; //维护单选开关状态
  bool _checkboxSelected = true; //维护复选框状态

  FocusNode focusNode1 = new FocusNode();
  FocusNode focusNode2 = new FocusNode();
  FocusScopeNode focusScopeNode;

  AnimationController _animationController;

  @override
  void initState() {
    //动画执行时间3秒
    _animationController =
        new AnimationController(vsync: this, duration: Duration(seconds: 3));
    _animationController.forward();
    _animationController.addListener(() => setState(() => {}));
    super.initState();
  }

  @override
  void dispose() {
    _animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Switch(
          value: _switchSelected, //当前状态
          onChanged: (value) {
            //重新构建页面
            setState(() {
              _switchSelected = value;
            });
          },
        ),
        Checkbox(
          value: _checkboxSelected,
          activeColor: Colors.red, //选中时的颜色
          onChanged: (value) {
            setState(() {
              _checkboxSelected = value;
            });
          },
        ),
        // 模糊进度条(会执行一个动画)
        LinearProgressIndicator(
          backgroundColor: Colors.grey[200],
          valueColor: AlwaysStoppedAnimation(Colors.blue),
        ),
//进度条显示50%
        LinearProgressIndicator(
          backgroundColor: Colors.grey[200],
          valueColor: AlwaysStoppedAnimation(Colors.blue),
          value: .5,
        ),
        // 模糊进度条(会执行一个旋转动画)
        CircularProgressIndicator(
          backgroundColor: Colors.grey[200],
          valueColor: AlwaysStoppedAnimation(Colors.blue),
        ),
        //进度条显示50%，会显示一个半圆
        CircularProgressIndicator(
          backgroundColor: Colors.grey[200],
          valueColor: AlwaysStoppedAnimation(Colors.blue),
          value: .5,
        ),
        // 线性进度条高度指定为3
        SizedBox(
          height: 3,
          child: LinearProgressIndicator(
            backgroundColor: Colors.grey[200],
            valueColor: AlwaysStoppedAnimation(Colors.blue),
            value: .5,
          ),
        ),
        // 圆形进度条直径指定为100
        SizedBox(
          height: 100,
          width: 100,
          child: CircularProgressIndicator(
            backgroundColor: Colors.grey[200],
            valueColor: AlwaysStoppedAnimation(Colors.blue),
            value: .7,
          ),
        ),
        SingleChildScrollView(
          child: Column(
            children: <Widget>[
              Padding(
                padding: EdgeInsets.all(16),
                child: LinearProgressIndicator(
                  backgroundColor: Colors.grey[200],
                  valueColor: ColorTween(begin: Colors.grey, end: Colors.blue)
                      .animate(_animationController),
                  value: _animationController.value,
                ),
              ),
            ],
          ),
        ),
        TextField(
          autofocus: true,
          decoration: InputDecoration(
              labelText: "用户名",
              hintText: "用户名或邮箱",
              prefixIcon: Icon(Icons.person)),
        ),
        TextField(
          decoration: InputDecoration(
              labelText: "密码",
              hintText: "您的登录密码",
              prefixIcon: Icon(Icons.lock)),
          obscureText: true,
        ),
        TextField(
          autofocus: true,
          focusNode: focusNode1, //关联focusNode1
          decoration: InputDecoration(labelText: "input1"),
        ),
        TextField(
          focusNode: focusNode2, //关联focusNode2
          decoration: InputDecoration(labelText: "input2"),
        ),
        RaisedButton(
          child: Text("移动焦点"),
          onPressed: () {
            //将焦点从第一个TextField移到第二个TextField
            // 这是一种写法 FocusScope.of(context).requestFocus(focusNode2);
            // 这是第二种写法
            if (null == focusScopeNode) {
              focusScopeNode = FocusScope.of(context);
            }
            focusScopeNode.requestFocus(focusNode2);
          },
        ),
        RaisedButton(
          child: Text("隐藏键盘"),
          onPressed: () {
            // 当所有编辑框都失去焦点时键盘就会收起
            focusNode1.unfocus();
            focusNode2.unfocus();
          },
        ),
      ],
    );
  }
}
