package br.com.locadoraferraz.util;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;

public class ListUtils {
   public static List<?> toList(Iterator<?> iterator){
	   return IteratorUtils.toList(iterator);
   }
}
