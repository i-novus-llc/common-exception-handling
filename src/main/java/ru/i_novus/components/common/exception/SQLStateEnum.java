package ru.i_novus.components.common.exception;

public enum SQLStateEnum
{
    UNIQUE_VIOLATION("23505", new String[] {"\\(([^\\)]+)\\)"}, new String[] {"unique_violation"}),

	FOREIGN_KEY_VIOLATION("23503", new String[] {
			"^.+DELETE[^\"]+\"([^\"]+)\".+\\(id\\)=\\(([0-9]+)\\)[^\"]+\"([^\"]+)\"",
			"^.+INSERT.+\\(([^\\)]+)\\)=\\(([0-9]+)\\).+\"([^\"]+)\""
	}, new String[] {
			"foreign_key_violation_delete",
			"foreign_key_violation_insert"
	});

    private String code;
    private String[] patterns;
    private String[] messageCodes;

    private SQLStateEnum(String code, String[] patterns, String[] messageCodes)
    {
        this.code = code;
        this.patterns = patterns;
        this.messageCodes = messageCodes;
    }

    public String[] getMessageCodes()
    {
        return messageCodes;
    }

    public void setMessageCodes(String[] messageCodes)
    {
        this.messageCodes = messageCodes;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String[] getPatterns()
    {
        return patterns;
    }

    public void setPatterns(String[] patterns)
    {
        this.patterns = patterns;
    }

    public static SQLStateEnum getSQLStateEnum(String code)
    {
        for(SQLStateEnum anEnum : values())
        {
            if(anEnum.getCode().equals(code))
                return anEnum;
        }

        return null;
    }
}
