package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


// ポイント:Aspect
@Aspect
@Component
public class LogAspect {

	//ポイント AOP実装
	//ポイント コントローラークラスの全てのメソッドを対象にする
	/*
	 * executionの指定方法
	 * "execution(<戻り値> <パッケージ名>.<クラス名>.<メソッド名>(<引数>)"
	 *
	 * 下記の場合
	 * *で全ての戻り値を指定
	 * パッケージ名「*..*」とすることで、全てのパッケージが対象に
	 * クラス名「*Controller」と指定することで、末尾にControllerとつくクラスが対象に
	 * メソッド名 *
	 * 引数に「..」を指定して全ての引数が対処に
	 *
	 */

	@Before("execution(* *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("method started : " + jp.getSignature());
	}

	@After("execution(* *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("method ended : " + jp.getSignature());
	}

}
