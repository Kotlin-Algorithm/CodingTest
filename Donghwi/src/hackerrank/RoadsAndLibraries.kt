package hackerrank

class RoadsAndLibraries {
    fun load() {
        val q = readln().trim().toInt()
        for(qItr in 1..q) {
            val first_multiple_input = readLine()!!.trimEnd().split(" ")

            val n = first_multiple_input[0].toInt()

            val m = first_multiple_input[1].toInt()

            val c_lib = first_multiple_input[2].toInt()

            val c_road = first_multiple_input[3].toInt()

            val cities = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

            for (i in 0 until m) {
                cities[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
            }

            val result = roadsAndLibraries(n, c_lib, c_road, cities)

            println(result)
        }
    }

    private fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array<Array<Int>>){
        if(c_lib <= c_road) {
            println((n * c_lib).toLong())
        } else {
            val cityMap = mutableMapOf<Int, MutableList<Int>>()

            for(city in cities) {
                val cityA = city[0]
                val cityB = city[1]

                cityMap.computeIfAbsent(cityA) { mutableListOf() }.add(cityB)
                cityMap.computeIfAbsent(cityB) { mutableListOf() }.add(cityA)
            }
            println(cityMap)

            val visited = mutableSetOf<Int>()
            val componentSizes = mutableListOf<Int>()

            fun dfs(node: Int): Int {
                var size = 1
                visited.add(node)
                for (neighbor in cityMap[node] ?: emptyList()) {
                    if (neighbor !in visited) {
                        size += dfs(neighbor)
                    }
                }
                return size
            }

            // 모든 노드에 대해 연결 컴포넌트를 탐색
            for (node in 1..n) {
                if (node !in visited) {
                    val size = dfs(node)
                    componentSizes.add(size)
                }
            }

            println(componentSizes)

        }
    }
}