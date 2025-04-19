'''
I know the solution in python is way easier compared to java and rest of the languages

Hoping this would works

Time complexity --> O(n)--> In the worst case we visit every employee.

Space Complexity --> 0(n) --> Just the queue.
'''

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        final_res = 0

        hash_map  ={}

        for emp in employees:
            hash_map[emp.id] =[emp.importance, emp.subordinates]

        queue = deque()

        queue.append(hash_map[id])

        while(queue):

            importance, sub_ord = queue.popleft()

            final_res += importance

            for ordinates in sub_ord:
                queue.append(hash_map[ordinates])


        return final_res









