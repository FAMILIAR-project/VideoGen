/**
 */
package playlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import playlist.Entry;
import playlist.PlaylistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntryTest extends TestCase {

	/**
	 * The fixture for this Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Entry fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntryTest.class);
	}

	/**
	 * Constructs a new Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Entry fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Entry getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createEntry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //EntryTest
