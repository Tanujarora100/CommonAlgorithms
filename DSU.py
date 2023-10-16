class UnionFind:
    def __init__(self, size):
        self.root = list(range(size))
        self.rank = [0] * size
        self.num_components = size

    def find(self, x):
        if x == self.root[x]:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x, y):
        r_x, r_y = self.find(x), self.find(y)
        if r_x == r_y:
            return True
        if self.rank[r_x] > self.rank[r_y]:
            self.root[r_y] = r_x
        elif self.rank[r_y] > self.rank[r_x]:
            self.root[r_x] = r_y
        else:
            self.root[r_x] = r_y
            self.rank[r_y] += 1
        self.num_components -= 1
        return False
