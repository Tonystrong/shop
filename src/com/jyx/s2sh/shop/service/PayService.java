package com.jyx.s2sh.shop.service;

import java.util.Map;

import com.jyx.s2sh.shop.domain.BackData;
import com.jyx.s2sh.shop.domain.SendData;

public interface PayService {

	Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);

	boolean checkBackData(BackData backData);

}
