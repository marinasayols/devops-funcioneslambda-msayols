package func_lambda;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .map(User::familyNameInitial);
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after:" + x))
                .map(User::getId);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("users before: " + x))
                .filter(user -> familyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("users after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .peek(x -> LogManager.getLogger(this.getClass()).info("fractions: " + x))
                .reduce(Fraction::multiplication)
                .orElse(new Fraction());
    }

    public Fraction findFirstFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream()).limit(2)
                .peek(x -> LogManager.getLogger(this.getClass()).info("fractions: " + x))
                .reduce(Fraction::division)
                .orElse(new Fraction());
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream()).limit(2)
                .peek(x -> LogManager.getLogger(this.getClass()).info("fractions: " + x))
                .reduce(Fraction::division).get().decimal();
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(Fraction::isProper))
                .map(User::getName);
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Predicate.not(Fraction::isProper))
                .map(Fraction::decimal);
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(new Fraction());
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(Predicate.not(Fraction::isProper)))
                .map(User::getFamilyName);
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .max(Comparator.comparingDouble(Fraction::decimal))
                .orElse(new Fraction());
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Predicate.not(Fraction::isProper)))
                .map(User::getName);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isNegative))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isNegative)
                .map(Fraction::decimal);
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::addition)
                .orElse(new Fraction());
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream()).limit(2)
                .reduce(Fraction::subtraction)
                .orElse(new Fraction());
    }

}