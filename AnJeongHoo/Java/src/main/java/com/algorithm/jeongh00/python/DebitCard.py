class CreditCard:

    def __init__(self, customer, bank, account, limit, balance):
        self._customer = customer
        self._bank = bank
        self._account = account
        self._limit = limit
        self._balance = balance

    def get_customer(self):
        return self._customer

    def get_bank(self):
        return self._bank

    def get_account(self):
        return self._account

    def get_limit(self):
        return self._limit

    def get_balance(self):
        return self._balance

    def charge(self, price):
        if price + self._balance > self._limit:
            return False
        else:
            self._balance += price
            return True

    def make_payment(self, amount):
        self._balance -= amount

class DebitCard(CreditCard):

    def __init__(self, customer, bank, account, limit, balance, monthly_interest_rate, monthly_interest_payment_date):

        super().__init__(customer, bank, account, limit, balance)
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

def main():
    # DebitCard 객체 생성
    debit_card = DebitCard("Jeonghoo An", "Best Bank", "1234567890", 1000, 500, 0.05, 15)

    # 현재 잔액 확인
    print("현재 잔액:", debit_card.get_balance())

    # 입금 시도
    debit_card.deposit(200)
    print("입금 후 잔액:", debit_card.get_balance())

    # 출금 시도
    debit_card.withdraw(100)
    print("출금 후 잔액:", debit_card.get_balance())

    # 월 이자 계산 및 지급
    interest = debit_card.calculate_monthly_interest()
    print("이번 달 이자:", interest)
    debit_card.pay_monthly_interest()
    print("이자 지급 후 잔액:", debit_card.get_balance())

main()