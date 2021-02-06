package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
//@Setter

@ToString(of = { "customerName" })

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

@Builder
public class OrderDTO {
	String customerName;
}
