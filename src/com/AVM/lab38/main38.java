package com.AVM.lab38;

import java.util.Arrays;

/**
 * Created by AVM on 19.07.2016.
 *  * Для работы с банковским счетом отдельного пользователя был разработан абстрактный класс Account.
 *
 * Поле amount хранит сумму на счете пользователя.
 *
 * Метод change(int delta) throws TryAgainException, BlockAccountException
 * изменяет счет пользователя на значение дельты. Дельта может быть отрицательной.
 *
 * Этот метод имеет две нестандратные ситуации:
 *
 * class TryAgainException extends Exception {
 *
 * }
 *
 * Метод сообщает о временной неудаче, что значит:
 *
 * 1. Ничего не сделано.
 *
 * 2. Необходимо попробывать вызвать метод еще раз (а потом еще раз, и т.д. пока операция не пройдет).
 *
 * class BlockAccountException extends Exception {
 *
 * }
 *
 * Метод сообщает о полном блокировании счета, что значит:
 *
 * 1. Ничего не сделано.
 *
 * 2. Нет смысла вызывать метод еще раз.
 *
 * AccountManager - часть системы, которую необходимо изменить. (Менеджер счетов).
 *
 * На вход подается массив счетов и массив дельт для изменения. Массивы одинаковой длинны.
 *
 * В теле метода используется следующий код: accounts[k].change(deltas[k]) для всего массива счетов.
 *
 * Если при работе со счетом возникает TryAgainException необходимо повторять
 * ситуацию до появления положительного результата.
 *
 * При BlockAccountException необходимо сделать откат всех предыдущих изменений и завершить работу.
 * Т.е вернуть деньги на счета, с которых уже успели снять/положить деньги.
 *
 * На выходе метод возвращает true/false.
 *
 * true - если получилось перевести деньги на все счета.
 *
 * false - во всех остальных случаях.
 *
 */

public class main38 {
    public static void main(String[] args) {
        Account[] testAccounts = new Account[3];
        int[] testDelta = {100, 343, 245};
        int[] amountArray = {10, 5, 25};
        for (int i = 0; i < testAccounts.length; i++) {
            testAccounts[i] = new Account(amountArray[i]) {
                @Override
                public void change(int delta) throws TryAgainException, BlockAccountException {
                    amount = amount + delta;
                }
            };
        }

        System.out.println(AccountManager.transfer(testAccounts, testDelta));
    }
}
