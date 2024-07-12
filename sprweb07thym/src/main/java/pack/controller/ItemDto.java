package pack.controller;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
	private int price;
	private String id, name;
	private LocalDate regDate;
}
