class Sieve_Of_Ertosthenes:
    def __init__(self, limit: int):
        self.limit = limit
        # Initialise all the numbers to be as primes
        self.prime = [True for _ in range(limit + 1)]

    def create_sieve(self):
        # Set '0' and '1' to be non primes (Not exactly true to say so.)
        self.prime[0] = False
        self.prime[1] = False

        for i in range(self.limit + 1):
            if not self.prime[i]:
                continue
            for j in range(i * i, self.limit + 1, i):
                self.prime[j] = False

    def is_prime(self, x: int) -> bool:
        return self.prime[x]


def test():
    x = input('Enter an integer till which you wish to find primes: ')
    try:
        x = int(x) # make x to be an int
    except ValueError:
        print('Enter an integer next time.')
        return

    sieve = Sieve_Of_Ertosthenes(x)
    sieve.create_sieve()

    for i in range(1, x + 1):
        print(f"{i} is{' NOT' if not sieve.is_prime(i) else ''} a PRIME!")


if __name__ == "__main__":
    test()
