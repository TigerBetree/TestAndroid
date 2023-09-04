import 'package:flutter/material.dart';

class HeroAnimationTest extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'HeroAnimationTest',
      theme: new ThemeData(
        primarySwatch: Colors.blue, // 主色板
      ),
      home: Scaffold(
        appBar: new AppBar(
          title: new Text('HeroAnimationTest'),
        ),
        body: new HeroAnimationRoute(),
      ),
    );
  }
}

// 路由A
class HeroAnimationRoute extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.topCenter,
      child: InkWell( // 水波纹效果
        child: Hero(
          tag: "avatar", //唯一标记，前后两个路由页Hero的tag必须相同
          child: ClipOval( // 椭圆形
            child: Image.asset(
              "images/head.jpg",
              width: 50.0,
            ),
          ),
        ),
        onTap: () {
          //打开B路由
          Navigator.push(context, PageRouteBuilder(pageBuilder:
              (BuildContext context, Animation animation,
                  Animation secondaryAnimation) {
            return new FadeTransition(
              opacity: animation,
              child: Scaffold(
                appBar: AppBar(
                  title: Text("原图"),
                ),
                body: HeroAnimationRouteB(),
              ),
            );
          }));
        },
      ),
    );
  }
}

class HeroAnimationRouteB extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Hero(
        tag: "avatar", //唯一标记，前后两个路由页Hero的tag必须相同
        child: Image.asset("images/head.jpg"),
      ),
    );
  }
}
