class DebitCard(CreditCard):

    def __init__(self, customer, bank, account, limit, monthly_interest_rate, monthly_interest_payment_date):

        super().__init__(customer, bank, account, limit, balance=0)
        self._monthly_interest_rate = monthly_interest_rate  # 월 이자율
        self._monthly_interest_payment_date = monthly_interest_payment_date  # 월 이자 지급 일자

    def set_monthly_interest_rate(self, monthly_interest_rate):
        self._monthly_interest_rate = monthly_interest_rate

    def set_monthly_interest_payment_date(self, monthly_interest_payment_date):
        self._monthly_interest_payment_date = monthly_interest_payment_date

    def deposit(self, amount):
        self._balance += amount

    def withdraw(self, amount):
        if self._balance - amount >= 0:
            self._balance -= amount
            return True
        else:
            print("잔금이 부족합니다!!")
            return False

    def calculate_monthly_interest(self):
        return self._balance * self._monthly_interest_rate

    def pay_monthly_interest(self):
        interest = self._calculate_monthly_interest()
        self._balance += interest
        print(f"이번 달 이자 {interest} 는 {self._monthly_interest_payment_date} 에 지급됩니다!!")
