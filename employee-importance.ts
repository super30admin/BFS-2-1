/**
 * Definition for Employee.
 * class Employee {
 *     id: number
 *     importance: number
 *     subordinates: number[]
 *     constructor(id: number, importance: number, subordinates: number[]) {
 *         this.id = (id === undefined) ? 0 : id;
 *         this.importance = (importance === undefined) ? 0 : importance;
 *         this.subordinates = (subordinates === undefined) ? [] : subordinates;
 *     }
 * }
 */
// Time complexity - O(n), n = number of employees
// Space complexity - O(n)
function getImportance(employees: Employee[], id: number): number {
	const map = new Map<number, Employee>();
	// setup an employee lookup map by Id
	for (let employee of employees) {
		map.set(employee.id, employee);
	}

	// add the given employee Id to queue to calculate importance
	let q = [id];
	let result = 0;

	while (q.length > 0) {
		const eid = q.shift();
		const emp = map.get(eid);

		// add current employee importance to total
		result += emp.importance;

		// add all subordinates of current employee to queue for processing
		for (let subordinate of emp.subordinates) {
			q.push(subordinate);
		}
	}
	return result;
}
