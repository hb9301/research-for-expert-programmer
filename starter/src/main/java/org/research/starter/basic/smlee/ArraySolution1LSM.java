package org.research.starter.basic.smlee;

import java.util.Arrays;

/**
 * 문제 설명
 * S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다.
 * 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다.
 * 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
 * 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다.
 * 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
 * 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
 * d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
 * budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
 *
 * 입출력 예
 * d	        budget	result
 * [1,3,2,5,4]	9	    3
 * [2,2,3,3]	10	    4
 */

public class ArraySolution1LSM {

    public static void main(int[] d1, int budget1) {
        ArraySolution1LSM arraySolution1LSM = new ArraySolution1LSM();

        // 제한사항 체크
        boolean validate = arraySolution1LSM.validate(d1, budget1);

        if(validate) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println("총신청부서 : " + d1.length);
            System.out.println("부서별 신청한 금액 : " + Arrays.toString(d1));
            System.out.println("예산 : " + budget1);
            System.out.println("최대물품지원횟수 : " + arraySolution1LSM.solution(d1, budget1));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
    }

    // 제한사항
    public boolean validate(int[] d, int budget){
        boolean result = true;
        int length = d.length;

        // d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
        if(!(length >= 1 && length <= 100)){
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println("총신청부서 : " + length);
            System.out.println("신청 부서의 최대 신청 개수를 초과했습니다");
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            result = false;
        }

        // d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
        for(int i : d){
            if(!(i >= 1 && i <= 100000)){
                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                System.out.println("신청금액 : " + i);
                System.out.println("신청 금액이 초과되었습니다");
                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                result = false;
                break;
            }
        }

        // budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
        if(!(budget >= 1 && budget <= 10000000)){
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.println("예산 : " + budget);
            System.out.println("예산이 초과되었습니다");
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            result = false;
        }

        return result;
    }

    // 결과
    public int solution(int[] d, int budget) {
        int answer = 0;

        // 작은값부터 처리해야 부서별 신청한 금액 맞춰주며 + 최대 부서 지원 가능.
        Arrays.sort(d);

        for (int i : d){
            // 예산이 신청한 금액보다 크거나 같을때만
            if(budget >= i) {
                budget = budget - i;
                // 지원가능 부서 카운트
                answer++;
            }else
                break;
        }

        return answer;
    }

}