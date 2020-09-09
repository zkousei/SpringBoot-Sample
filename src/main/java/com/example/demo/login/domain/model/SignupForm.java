package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	//必須入力、メールアドレス形式
    @NotBlank(message = "{require_check}",groups = ValidGroup1.class)
    @Email(message = "{email_check}", groups = ValidGroup2.class)
	private String userId;

    // 必須入力、長さ４から100桁まで、半角英数字のみ
    @NotBlank(message = "{require_check}" ,groups = ValidGroup1.class)
    @Length(min = 4, max = 100,message = "{length_check}" ,groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "{pattern_check}", groups = ValidGroup3.class)
	private String password;
    @NotBlank(message = "{require_check}", groups = ValidGroup1.class)
	private String userName;

	//ポイント　@DateTimeFormatアノテーション
    @NotNull(message = "{require_check}", groups = ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
    @Min(value = 20,message = "{min_check}", groups = ValidGroup2.class)
    @Max(value = 100, message = "{max_check}", groups = ValidGroup2.class)
	private int age;
    @AssertFalse(message = "{false_check}", groups = ValidGroup2.class)
	private boolean marriage;


}
