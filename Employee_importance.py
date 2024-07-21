class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

def getImportance(employees, id):
    # Create a dictionary to map employee ID to the Employee object
    employee_dict = {employee.id: employee for employee in employees}
    print(employee_dict)
    
    def dfs(emp_id):
        employee = employee_dict[emp_id]
        total_importance = employee.importance
        for sub_id in employee.subordinates:
            total_importance += dfs(sub_id)
        return total_importance
    
    # Start DFS from the given employee ID
    return dfs(id)

# Example usage:
employees = [
    Employee(1, 5, [2, 3]),
    Employee(2, 3, []),
    Employee(3, 3, [])
]
print(getImportance(employees, 1))  # Output: 11

#time = O(N)
#space = O(N)