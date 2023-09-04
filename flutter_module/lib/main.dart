import 'package:flutter/cupertino.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter_module/ListViewTest.dart';
import 'package:flutter_module/NetSampleApp.dart';
import 'package:flutter_module/NotificationTest.dart';
import 'package:flutter_module/TestStateMgr.dart';
import 'package:flutter_module/demo/Demo02_MyCardDemo.dart';
import 'package:flutter_module/gesture/DragTest.dart';
import 'package:flutter_module/gesture/DragVerticalTest.dart';
import 'package:flutter_module/net/HttpTest.dart';
import 'package:flutter_module/widget/CustomPaintTest.dart';
import 'package:flutter_module/widget/FlexTest.dart';
import 'package:flutter_module/widget/ThemeTest.dart';
import 'package:toast/toast.dart';

import 'CustomScrollViewTest.dart';
import 'FadeAppTest.dart';
import 'GridViewTest.dart';
import 'LifecycleWatcher.dart';
import 'ListViewSample.dart';
import 'MyApp.dart';
import 'SampleApp.dart';
import 'ScaffoldTest.dart';
import 'ScrollControllerTest.dart';
import 'ScrollNotificationTest.dart';
import 'anim/AnimatedSwitcherTest.dart';
import 'anim/AnimatedWidgetsTest.dart';
import 'anim/HeroAnimationTest.dart';
import 'anim/ScaleAnimationTest.dart';
import 'anim/StaggerAnimationTest.dart';
import 'demo/Demo03_AwesomeButton.dart';
import 'demo/Demo05_MyTextInput.dart';
import 'demo/Demo08_TabNavigation.dart';
import 'demo/Demo09_Http.dart';
import 'demo/Demo11_SandyShores.dart';
import 'demo/Demo11_SimpleDrawer.dart';
import 'demo/Demo12_Loader.dart';
import 'demo/Demo13_JSONStorageDemo.dart';
import 'demo/Demo14_FriendlyChatApp.dart';
import 'demo/Demo15_ChangeIconColor.dart';
import 'demo/Demo16_HorizontalListViewTabs.dart';
import 'demo/Demo17_18_19_20_Button.dart';
import 'demo/Demo21_22_23.dart';
import 'demo/Demo24_25_26_27_28_29_30.dart';
import 'demo/Demo31_32_33_34_35.dart';
import 'demo/Demo36_37_38.dart';
import 'demo/Demo39_40.dart';
import 'demo/Demo41_42.dart';
import 'demo/Demo43.dart';
import 'file/FileOperationTest.dart';
import 'gesture/BothDirectionTest.dart';
import 'gesture/GestureDetectorTest.dart';
import 'gesture/GestureRecognizerTest.dart';
import 'net/DioTest.dart';
import 'net/WebSocketTest.dart';
import 'widget/ClipTest.dart';
import 'widget/CustomGradientButtonTest.dart';
import 'widget/CustomGradientCircularProgressTest.dart';
import 'widget/CustomTurnBoxTest.dart';
import 'widget/FormTest.dart';
import 'widget/ImageAndIconRoute.dart';
import 'widget/InheritedWidgetTest.dart';
import 'widget/MyImageDemo.dart';
import 'widget/WidgetTest.dart';
import 'widget/WillPopScopeTest.dart';

void main() {
  runApp(new MaterialApp(
    title: 'Flutter Demo',
    theme: ThemeData(
      primarySwatch: Colors.blue,
    ),
    home: MyHomeApp(title: 'Flutter Demo'),
    routes: <String, WidgetBuilder>{
      // 注册路由表
      "/sampleApp": (BuildContext context) => new SampleApp()
    },
  ));
}

class MyHomeApp extends StatefulWidget {
  MyHomeApp({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomeAppState createState() => _MyHomeAppState();
}

class _MyHomeAppState extends State<MyHomeApp> {
  final TapGestureRecognizer _recognizer = TapGestureRecognizer();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _recognizer.onTap = () {
      Toast.show("点击链接", context,
          duration: Toast.LENGTH_SHORT, gravity: Toast.BOTTOM);
    };
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Scrollbar(
        child: SingleChildScrollView(
          padding: EdgeInsets.only(bottom: 50.0),
          child: Center(
            // Center is a layout widget. It takes a single child and positions it
            // in the middle of the parent.
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text.rich(TextSpan(children: [
                  TextSpan(text: "Home: "),
                  TextSpan(
                    text: "https://flutterchina.club",
                    style: TextStyle(color: Colors.blue),
                    recognizer: _recognizer,
                  ),
                ])),
                new RaisedButton(
                  child: new Text('MyApp'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(builder: (context) => new MyApp()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo12_LoaderHome'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new LoaderHome()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo13_JSONStorageDemo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new JSONStorageDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo14_FriendlychatApp'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new FriendlychatApp()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo15_ChangeIconColor'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ChangeIconColor()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo16_HorizontalListViewTabsDemo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) =>
                              new HorizontalListViewTabsDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo17_18_19_20_ButtonDemo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ButtonDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo21_22_23_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new TextFieldDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo24_25_26_27_28_29_30_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new SwitchDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo31_32_33_34_35_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new BottomNavigationBarDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo36_37_38_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new RowColumnDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo39_40_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ListViewBuilderDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo41_42_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new CustomWidgetDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo43_Demo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ListviewBuilderRefreshIndicatorDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('SampleApp'),
                  onPressed: () {
                    // Navigator.pushNamed(context, "/sampleApp");
                    Navigator.of(context).pushNamed("/sampleApp");
                  },
                ),
                new RaisedButton(
                  child: new Text('FadeAppTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new FadeAppTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('TestStateMgr'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new TestStateMgr()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('NetSampleApp'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new NetSampleApp()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('LifecycleWatcher'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new LifecycleWatcher()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ListViewSample'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ListViewSample()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('InfiniteListViewSample'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ListViewTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('GridViewTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new GridViewTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ImageAndIconRoute'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ImageAndIcon()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('WidgetTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new WidgetTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('TextFormField'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new FormTestRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('FlexTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new FlexTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ClipTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ClipTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ScaffoldRouteTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ScaffoldRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('CustomScrollViewTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) =>
                              new CustomScrollViewTestRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ScrollControllerTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ScrollControllerTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ScrollNotificationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ScrollNotificationTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('WillPopScopeTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new WillPopScopeTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('InheritedWidgetTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new InheritedWidgetTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ThemeTestRoute'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new ThemeTestRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('GestureDetectorTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new GestureDetectorTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('DragTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new DragTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('DragVerticalTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new DragVerticalTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('GestureRecognizerTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new GestureRecognizerTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('BothDirectionTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      new MaterialPageRoute(
                          builder: (context) => new BothDirectionTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('NotificationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new NotificationTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('ScaleAnimationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 自定义页面切换动画
                      PageRouteBuilder(
                        transitionDuration: Duration(milliseconds: 500),
                        //动画时间为500毫秒
                        pageBuilder: (BuildContext context, Animation animation,
                            Animation secondaryAnimation) {
                          return new FadeTransition(
                            //使用渐隐渐入过渡,
                            opacity: animation,
                            child: ScaleAnimationTest(), //路由B
                          );
                        },
                      ),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('HeroAnimationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new HeroAnimationTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('StaggerAnimationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new StaggerAnimationTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('AnimatedSwitcherTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new AnimatedSwitcherTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('AnimatedWidgetsTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new AnimatedWidgetsTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('CustomGradientButtonTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new CustomGradientButtonTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('CustomTurnBoxTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new CustomTurnBoxTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('CustomPaintTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new CustomPaintTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('GradientCircularProgressTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) =>
                              new GradientCircularProgressTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('FileOperationTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new FileOperationRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('HttpTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new HttpTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('DioTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new DioTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('WebSocketTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new WebSocketRoute()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo02_MyCardDemo'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new MyCardDemo()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo03_AwesomeButton'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new Demo03_AwesomeButton()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo05_MyTextInput'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new MyTextInput()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo08_TabNavigation'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new MyTabs()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo09_Http'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new HttpTestPage()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('MyImageDemo-ImageInternalTest'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new ImageInternalTest()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo11_SimpleDrawerHomePage'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new SimpleDrawerHomePage()),
                    );
                  },
                ),
                new RaisedButton(
                  child: new Text('Demo11_SandyShores'),
                  onPressed: () {
                    Navigator.push(
                      context,
                      // 右侧进入动画
                      new CupertinoPageRoute(
                          builder: (context) => new MySandyShoresApp()),
                    );
                  },
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
