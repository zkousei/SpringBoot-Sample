package com.example.demo.login.domain.model;

import javax.validation.GroupSequence;

//バリデーショングループの実行順序を設定
@GroupSequence({ValidGroup1.class,ValidGroup2.class,ValidGroup3.class})
public interface GroupOrder {

}
