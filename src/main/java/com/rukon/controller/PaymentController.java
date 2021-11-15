package com.rukon.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class PaymentController {
    @GetMapping("/api/v1/payment")
    private ModelAndView createPayment(HttpServletRequest request) throws StripeException {
        Stripe.apiKey = "sk_test_51JpmkgI09skCaQA28GbBMsK23W4kMB9fKOzoXEubqznMSV0RFt7xVZfkf5prjK0UA6OiUDKnYWIwYi5GcG2pLCx00040YpKLj0";
        ModelAndView mav = new ModelAndView();
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl("http://localhost:4242/success.html")
                        .setCancelUrl("http://localhost:4242/cancel.html")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        .setPriceData(
                                                SessionCreateParams.LineItem.PriceData.builder()
                                                        .setCurrency("usd")
                                                        .setUnitAmount(200L)
                                                        .setProductData(
                                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                        .setName("T-shirt")
                                                                        .build())
                                                        .build())
                                        .build())
                        .build();

        Session session = Session.create(params);
        mav.setViewName("redirect:" + session.getUrl());
        return mav;

    }
}
