
/**
 * Definition for Employee.
 * function Employee(id, importance, subordinates) {
 *     this.id = id;
 *     this.importance = importance;
 *     this.subordinates = subordinates;
 * }
 */

/**
 * @param {Employee[]} employees
 * @param {number} id
 * @return {number}
 */
var GetImportance = function(employees, id) {
    let totalImp = 0;
    let queue = [];
    let employeeMap = new Map();

    //Create O(1) lookup for all the employees array
    for(let emp of employees){
        employeeMap.set(emp.id, emp);
    }

    queue.push(employeeMap.get(id));
    //In each loop, add the subordinates available for the curr emp to queue. Run while till it is exhausted.
    while(queue.length > 0){
        let currEmp = queue.pop();
        for(let subId of currEmp.subordinates){
            queue.push(employeeMap.get(subId)); 
        }
         totalImp+=currEmp.importance; // add current employee's importance
    }
    return totalImp;
};