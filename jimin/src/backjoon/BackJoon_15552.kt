package backjoon

import common.Solution
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class BackJoon_15552: Solution {
    override fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        //writer
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        repeat(br.readLine().toInt()) {
            //token, br.readLine()에 대해서 token을 생성
            val token = StringTokenizer(br.readLine())
            //각각 한줄 씩 읽어서 sum
            val sum = token.nextToken().toInt() + token.nextToken().toInt()
            //writer에 출력을 저장
            bw.write("$sum \n")
        }
        //저장된 모든 writer 한번에 전송
        bw.flush()
        //사용된 buffer close
        bw.close()
    }
}