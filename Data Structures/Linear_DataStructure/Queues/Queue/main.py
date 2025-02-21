from queue import Queue

class Queues:
	def __init__(self):
		self.elements = []

	def enqueue(self, data):
		self.elements.append(data)
		return data

	def dequeue(self):
		return self.elements.pop(0)

	def rear(self):
		return self.elements[-1]

	def front(self):
		return self.elements[0]

	def is_empty(self):
		return len(self.elements) == 0

def main(method):
  if method == 'implementation':
    queue = Queues()
    print(queue.is_empty())
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)
    print(queue.is_empty())
    print(queue.front(), end=' ')
    print(queue.rear())
    queue.dequeue()
    print(queue.front(), end=' ')
    print(queue.rear())
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()
    print(queue.is_empty())

  if method == 'stl':
    queue_object = Queue()
    print(queue_object.empty())
    queue_object.put(1)
    queue_object.put(2)
    queue_object.put(3)
    queue_object.put(4)
    queue_object.put(5)
    print(queue_object.empty())
    print(queue_object.get())
    print(queue_object.get())
    print(queue_object.get())
    print("Size", queue_object.qsize())
    print(queue_object.get())
    print(queue_object.get())
    print(queue_object.empty())

if __name__ == '__main__':
	main("implementation")
  # main("stl")
  