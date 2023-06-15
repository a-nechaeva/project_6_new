package commands;

import commands.implemented.*;

import java.io.Serializable;

public enum CommandType implements Serializable {
    CLEAR(ClearCommand.class, "clear: clear the collection"),
    COUNT_BY_NUMBER_OF_PARTICIPANTS(CountByNumberOfParticipantsCommand.class, "count_by_number_of_participants numberOfParticipants : вывести количество элементов, значение поля numberOfParticipants которых равно заданному"),
    EXECUTE_SCRIPT(ExecuteScriptCommand.class, "execute_script <file_name>: read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode. USE RELATIVE PATHS."),
    EXIT(null, "exit: exit the program"),
    GROUP_COUNTING_BY_NAME(GroupCountingByNameCommand.class, "group_counting_by_name : сгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе"),
    HELP(HelpCommand.class, "help: shows this message"),
    INFO(InfoCommand.class, "info: output to the standard output stream information about the collection (type initialization date number of elements etc.)"),
    INSERT(InsertCommand.class, "insert <id> {element}: add a new element with the specified key"),
    PRINT_FIELD_DESCENDING_SINGLES_COUNT(PrintFieldDescendingSinglesCountCommand.class, "print_field_descending_singles_count : вывести значения поля singlesCount всех элементов в порядке убывания" ),
    REMOVE_GREATER(RemoveGreaterCommand.class, "remove_greater <Oscars>: remove from the collection all elements exceeding the specified"),
    REMOVE_GREATER_KEY(RemoveGreaterKeyCommand.class, "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный"),
    REMOVE_KEY(RemoveKeyCommand.class, "remove_key <id>: delete an element from the collection by its key"),
    REMOVE_LOWER(RemoveLowerCommand.class, "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный"),
    SHOW(ShowCommand.class, "show: output to the standard output stream all elements of the collection in the string representation"),
    UPDATE(UpdateCommand.class, "update <id> {element}: update the value of a collection element whose id is equal to the specified"),
    DEFAULT(DefaultCommand.class, ""),
    SERVICE(ServiceCommand.class, "");

    private final Class<? extends Executable> executableClass;
    private final String description;

    CommandType(Class<? extends Executable> executableClass, String description) {
        this.executableClass = executableClass;
        this.description = description;
    }

    public Class<? extends Executable> getExecutableClass() {
        return executableClass;
    }

    public String getDescription() {
        return description;
    }
}