package com.center.buuluu.cache.aop;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.center.buuluu.annotation.CacheKey;
import com.center.buuluu.annotation.Cacheable;
import com.center.buuluu.annotation.Cacheable.TypeMode;

@Aspect  
@Component 
public class CacheableAop {

	@Autowired 
	private RedisTemplate<Serializable, Serializable> redisTemplate;
    
    @Around("@annotation(cache)")  
    public Object cached(final ProceedingJoinPoint pjp,Cacheable cache) throws Throwable {  
          
        String key=getCacheKey(pjp, cache);  
       Object value= cacheValue(cache, key);    //从缓存获取数据  
        if(value!=null) return value;       //如果有数据,则直接返回  
          
       /* value = (Serializable) pjp.proceed();*/      //跳过缓存,到后端查询数据  
        return value;  
    }  
    private Object cacheValue(Cacheable cache,String key){
    	Object value = null;
    	if (cache.type()==TypeMode.STRING) {
    		  ValueOperations<Serializable, Serializable> valueOper = redisTemplate.opsForValue();
    	        value = valueOper.get(key);    
		}else if (cache.type()==TypeMode.HASH) {
			   HashOperations<Serializable, Object, Object> valueOper = redisTemplate.opsForHash();
			   String tableName = cache.table().getSimpleName();
 	            value = valueOper.get(tableName, key);
		}else if (cache.type()==TypeMode.LIST) {
			ListOperations<Serializable, Serializable> valueOper = redisTemplate.opsForList();
			value =valueOper.getOperations();
		}else if (cache.type()==TypeMode.SET) {
			SetOperations<Serializable, Serializable> valueOper = redisTemplate.opsForSet();
			 value = value =value=valueOper.getOperations();
		}
    	
    	return value;
    }
    
    /** 
     * 获取缓存的key值 
     * @param pjp 
     * @param cache 
     * @return 
     */  
    private String getCacheKey(ProceedingJoinPoint pjp,Cacheable cache) { 
    	String key = "";
    	Object[] args=pjp.getArgs(); 
    	  Annotation[][] pas=((MethodSignature)pjp.getSignature()).getMethod().getParameterAnnotations();  
          for(int i=0;i<pas.length;i++) {  
              for(Annotation an:pas[i]) {  
                  if(an instanceof CacheKey) {  
                      key =args[i].toString();  
                      break;  
                  }  
              }  
          }
          return key;
    }
    
}
