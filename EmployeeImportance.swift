//
//  EmployeeImportance.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/31/26.
//


class EmployeeImportance {
    
    private class QueueUsingLL<T> {

        class LinkedListNode<T> {
            var value: T
            var next: LinkedListNode<T>?
            init(value: T) {
                self.value = value
            }
        }

        private var front: LinkedListNode<T>?
        private var rear: LinkedListNode<T>?
        private var count: Int = 0

        func enqueue(_ val: T) {
            let newNode = LinkedListNode(value: val)
            if (front == nil) {
                front = newNode
                rear = newNode
            } else {
                rear?.next = newNode
                rear = newNode
            }
            count += 1
        }

        func dequeue() -> T? {
            if (front == nil) {
                return nil
            }

            let value = front?.value
            front = front?.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return value
        }

        var isEmpty: Bool {
            return count == 0
        }

        var size: Int {
            return count
        }
    }
    
    class Employee {
        let id: Int
        let importance: Int
        let subordinates: [Int]
        
        init(id: Int, importance: Int, subordinates: [Int]) {
            self.id = id
            self.importance = importance
            self.subordinates = subordinates
        }
    }

    //MARK: BFS
    /*
     time complexity -> Number of employees O(V)
     Actually O(V + E) -> E - no of edges. 1 employee is reporting to 1 manager only. So, E = V, O(2V) = O(V)
     */
    func getImportance(_ employees: [Employee], _ id: Int) -> Int {
        var hashMap = Dictionary<Int, Employee>()
        for employee in employees {
            hashMap[employee.id] = employee
        }

        //BFS
        let queue = QueueUsingLL<Int>()
        queue.enqueue(id)

        var totalImportance = 0
        while (!queue.isEmpty) {
            guard let empId = queue.dequeue() else {
                continue
            }
            if let employee = hashMap[empId] {
                totalImportance += employee.importance
                for subordinate in employee.subordinates {
                    queue.enqueue(subordinate)
                }
            }
        }
        return totalImportance
    }
    
    //MARK: Using DFS
    func getImportanceUsingDFS(_ employees: [Employee], _ id: Int) -> Int {

        var hashMap = Dictionary<Int, Employee>()
        for emp in employees {
            hashMap[emp.id] = emp
        }

        let totalImportance  = dfs(id: id, hashMap: hashMap)
        return totalImportance

    }

    func dfs(id: Int, hashMap: Dictionary<Int, Employee>) -> Int {
        guard let emp = hashMap[id] else {
            return 0
        }
        
        var totalImportance = emp.importance
        for subordinate in emp.subordinates {
            totalImportance += dfs(id: subordinate, hashMap: hashMap)
        }
        return totalImportance
    }
}
