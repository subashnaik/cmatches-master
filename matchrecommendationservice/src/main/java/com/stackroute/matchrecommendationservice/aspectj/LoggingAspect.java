package com.stackroute.matchrecommendationservice.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@AfterReturning("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.saveRecommendedMatch(..))")
	public void logAfterReturningRegisterUser(JoinPoint joinPoint) {
		logger.info("After returning Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.saveRecommendedMatch(..))")
	public void logAfterThrowingRegisterUser(JoinPoint joinPoint) {
		logger.info("After throwing Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.saveFavouriteMatch(..))")
	public void logAfterReturningSaveFavouriteMatch(JoinPoint joinPoint) {
		logger.info("After returning Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.saveFavouriteMatch(..))")
	public void logAfterThrowingSaveFavouriteMatch(JoinPoint joinPoint) {
		logger.info("After throwing Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@Before("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.deleteRecommendedMatch(..))")
	public void logBeforeDeleteFavouriteMatch(JoinPoint joinPoint) {
		logger.info("Before Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@After("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.deleteRecommendedMatch(..))")
	public void logAfterDeleteFavouriteMatch(JoinPoint joinPoint) {
		logger.info("After Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.deleteRecommendedMatch(..))")
	public void logAfterReturningDeleteFavouriteMatch(JoinPoint joinPoint) {
		logger.info("After returning Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("execution (* com.stackroute.matchrecommendationservice.controller.MatchRecommendationController.deleteRecommendedMatch(..))")
	public void logAfterThrowingDeleteFavouriteMatch(JoinPoint joinPoint) {
		logger.info("After throwing Aspect");
		logger.info("Method :: " + joinPoint.getSignature().getName());
	}
	
}