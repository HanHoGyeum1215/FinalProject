package app.user.course.command;

import lombok.Data;

@Data
public class OrderCommand {
   String memId;
   String venId;
   String orderAddr;
   String orderMsg;
   String goodsNo;
   String cartPrice;
   String totalPrice;
}
