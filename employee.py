# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        employee_map = {employee.id: employee for employee in employees}
        queue = [id]
        total_importance = 0
        
        while queue:
            current_id = queue.pop(0)
            total_importance += employee_map[current_id].importance
            queue.extend(employee_map[current_id].subordinates)
        
        return total_importance
