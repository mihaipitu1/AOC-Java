package com.mpitu.adventofcodesolution.solutions.year_2015.days;

import com.mpitu.adventofcodesolution.model.Solution;
import com.mpitu.adventofcodesolution.util.ISolution;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Day4Solution implements ISolution {
    @Override
    public Solution getAnswer(List<String> inputLines) {
        return Solution.builder()
                .firstPart(getPartOne(inputLines))
                .secondPart(getPartTwo(inputLines))
                .build();
    }

    private String getPartOne(List<String> inputLines) {
        Long startNumber = 0L;
        String input = inputLines.get(0);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            while(true) {
                String toDecrypt = String.format("%s%d",input, startNumber);
                byte[] messageDigest = md.digest(toDecrypt.getBytes());
                if(bytesToHex(messageDigest).startsWith("00000")) {
                    return startNumber.toString();
                } else {
                    startNumber++;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPartTwo(List<String> inputLines) {
        Long startNumber = 0L;
        String input = inputLines.get(0);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            while(true) {
                String toDecrypt = String.format("%s%d",input, startNumber);
                byte[] messageDigest = md.digest(toDecrypt.getBytes());
                if(bytesToHex(messageDigest).startsWith("000000")) {
                    return startNumber.toString();
                } else {
                    startNumber++;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] byteArray) {
        String result = "";
        for(int i = 0; i < byteArray.length; i++) {
            result += String.format("%02x",(byteArray[i] & 0xff));
        }
        return result;
    }

}
